package br.com.uniftec.trabalhofinal.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
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
                fragment = new ListaProdutosFragment();
                break;
            case R.id.menu_cadastro:
                fragment = new CadastroFragment();
                break;
            case R.id.menu_carrinho:
                fragment = new CarrinhoFragment();
                break;
            case R.id.menu_pedidos:
                fragment = new PedidosFragment();
                break;
        }

        if(fragment != null){
            mudarContainerPrincipal(fragment);
            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setupView() {

        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.main_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        mudarContainerPrincipal(new ListaProdutosFragment());

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
