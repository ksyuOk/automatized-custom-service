import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.android_client2.fragments.CategoryFragment;

public class MyActivity extends FragmentActivity implements CategoryFragment.ActionsListener{

    private CategoryFragment categoryFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        categoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentById(R.id.fr_category);
    }

    @Override
    public void onCategorySelected(String selectedItem) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
