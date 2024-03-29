package ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.alexisdo.R;
import edu.uw.tcss450.alexisdo.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if(view == binding.button1) {
            processColor(Color.RED);
        }
    }

    public void processColor(int color) {
        Log.d("ACTIVITY", "Red: " + Color.red(color) + " Green: " + Color.green(color) + " Blue: " + Color.blue(color));

        //The following object represents the action from first to color.
        FirstFragmentDirections.ActionFirstFragmentToColorFragment directions = FirstFragmentDirections.actionFirstFragmentToColorFragment(color);

        //Use the navigaiton method to perform the navigation.
        Navigation.findNavController(getView()).navigate(directions);
    }

    private void handleBlue(View v) {
        if (v == binding.button3) {
            processColor(Color.BLUE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //add this Fragment Object as the OnClickListener to the Red Button
        binding.button1.setOnClickListener(this);

        //Use a lamda expression to add the OnClickListener
        binding.button2.setOnClickListener(button -> processColor(Color.GREEN));

        //Use a method reference to add the OnClickListener
        binding.button3.setOnClickListener(this::handleBlue);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}