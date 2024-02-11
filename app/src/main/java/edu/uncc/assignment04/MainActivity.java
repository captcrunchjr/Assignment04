package edu.uncc.assignment04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import edu.uncc.assignment04.fragments.DemographicFragment;
import edu.uncc.assignment04.fragments.IdentificationFragment;
import edu.uncc.assignment04.fragments.ProfileFragment;
import edu.uncc.assignment04.fragments.SelectEducationFragment;
import edu.uncc.assignment04.fragments.SelectIncomeFragment;
import edu.uncc.assignment04.fragments.SelectLivingStatusFragment;
import edu.uncc.assignment04.fragments.SelectMaritalStatusFragment;

public class MainActivity extends AppCompatActivity implements DemographicFragment.goToProfileListener ,SelectIncomeFragment.IncomeFragmentListener, SelectLivingStatusFragment.SelectLivingStatusFragmentListener, SelectMaritalStatusFragment.MaritalStatusFragmentListener, IdentificationFragment.IdentificationFragmentListener, SelectEducationFragment.EducationFragmentListener, DemographicFragment.goToEducationListener, DemographicFragment.goToIncomeListener, DemographicFragment.goToLivingListener, DemographicFragment.goToMaritalListener {

    Response response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void EducationFragmentListener(String educationLevel) {
        response.setEducationLevel(educationLevel);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, DemographicFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToEducationListener(Response res) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, SelectEducationFragment.newInstance(res))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMaritalListener(Response res) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, SelectMaritalStatusFragment.newInstance(res))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToLivingListener(Response res) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, SelectLivingStatusFragment.newInstance(res))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToIncomeListener(Response res) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, SelectIncomeFragment.newInstance(res))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void IdentificationFragmentListener(Response res) {
        response = res;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, DemographicFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void LivingStatusFragmentListener(String livingStatus) {
        response.setLivingStatus(livingStatus);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, DemographicFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void MaritalStatusFragmentListener(String maritalStatus) {
        response.setMaritalStatus(maritalStatus);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, DemographicFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onIncomeFragmentInteraction(String income) {
        response.setIncome(income);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, DemographicFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToProfileListener(Response res) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, ProfileFragment.newInstance(res))
                .addToBackStack(null)
                .commit();
    }
}