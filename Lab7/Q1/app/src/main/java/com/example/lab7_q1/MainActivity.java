package com.example.lab7_q1;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<AppItem> apps = new ArrayList<>();
    PackageManager pm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pm = getPackageManager();
        listView = findViewById(R.id.listView);
        registerForContextMenu(listView);
        loadApps();
        AppAdapter adapter = new AppAdapter(this, apps);
        listView.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, systemBars.top, 0, systemBars.bottom);
            return insets;
        });
    }

    private void loadApps() {
        List<ApplicationInfo> installed = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo ai : installed) {
            if (ai.packageName.equals(getPackageName())) continue;
            CharSequence label = pm.getApplicationLabel(ai);
            String name = (label != null) ? label.toString() : ai.packageName;
            boolean isSystem = (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
            apps.add(new AppItem(
                    name,
                    ai.packageName,
                    pm.getApplicationIcon(ai),
                    isSystem));

        }
        Collections.sort(apps, Comparator.comparing(a -> (a.name != null ? a.name.toLowerCase() : "")));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_app, menu);

    }

    // Handle menu clicks using AdapterContextMenuInfo
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        AppItem selectedApp = apps.get(position);
        int id = item.getItemId();

        if (id == R.id.action_type) {
            Toast.makeText(this,
                    selectedApp.isSystemApp ? "System App" : "User Installed App",
                    Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.action_open) {
            Intent launch = pm.getLaunchIntentForPackage(selectedApp.packageName);
            if (launch != null) startActivity(launch);
            else Toast.makeText(this, "Cannot open this app", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.action_uninstall) {
            if (selectedApp.isSystemApp) {
                Toast.makeText(this, "System apps cannot be uninstalled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "UNINSTALL CLICKED: " + selectedApp.packageName, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
                intent.setData(Uri.parse("package:" + selectedApp.packageName));
                intent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
                startActivity(intent);
            }
            return true;

        } else if (id == R.id.action_details) {
            Intent details = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            details.setData(Uri.parse("package:" + selectedApp.packageName));
            startActivity(details);
            return true;

        } else if (id == R.id.action_special_perm) {
            boolean camera = pm.checkPermission(android.Manifest.permission.CAMERA, selectedApp.packageName)
                    == PackageManager.PERMISSION_GRANTED;
            boolean location = pm.checkPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, selectedApp.packageName)
                    == PackageManager.PERMISSION_GRANTED;

            Toast.makeText(this,
                    "Camera: " + (camera ? "Granted" : "Not Granted") +
                            "\nLocation: " + (location ? "Granted" : "Not Granted"),
                    Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onContextItemSelected(item);

    }
}