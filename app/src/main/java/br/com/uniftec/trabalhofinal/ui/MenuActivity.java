package br.com.uniftec.trabalhofinal.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import br.com.uniftec.trabalhofinal.R;

/**
 * Created by Fin on 07/12/2017.
 */

public class MenuActivity extends AbstractActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawers();

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_produtos:
               // fragment = new ListaProdutosFragment();
                break;
            case R.id.menu_cadastro:
                fragment = new Fragment();
                break;
            case R.id.menu_carrinho:
                // fragment carrinho
                break;
            case R.id.menu_pedidos:
                // fragment pedidos
                break;
        }

        if(fragment != null){
            mudarContainerPrincipal(fragment);
            return true;
        }

        return false;
    }

    @Override
    protected void setupView() {

        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.main_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

       // mudarContainerPrincipal(new ListaProdutosFragment());

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_menu;
    }


    private void mudarContainerPrincipal(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();
    }

}
