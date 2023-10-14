package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView listView;

    public static final String PAGE_UMB = "Página Institucional";
    public static final String SEARCH_PAGE = "Buscar Páginas";
    public static final String PAGE_MESSAGE = "Mensajes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView = (ListView) findViewById(R.id.listViewId);
        List<String> opMenu = new ArrayList<>();
        opMenu.add(PAGE_UMB);
        opMenu.add(SEARCH_PAGE);
        opMenu.add(PAGE_MESSAGE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opMenu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String) parent.getItemAtPosition(position);
                        switch (value){
                            case PAGE_UMB:
                                Intent umb = new Intent(getApplicationContext(),AppViewActivity.class);
                                umb.putExtra("cUrl","https://umbvirtual.edu.co/");
                                startActivity(umb);
                                break;
                            case SEARCH_PAGE:
                                Intent search = new Intent(getApplicationContext(),SearchPageActivity.class);
                                startActivity(search);
                                break;
                            case PAGE_MESSAGE:
                                Intent msg = new Intent(getApplicationContext(),RegisterActivity.class);
                                startActivity(msg);
                                break;
                            default:
                                break;
                        }
                    }
                }
        );
    }
}