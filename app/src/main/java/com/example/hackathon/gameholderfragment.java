package com.example.hackathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class gameholderfragment extends Fragment {


    Button clockwise, anticlockwise,cancel;
    viewmodel res;
    Observer<Boolean> selected;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gameholder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        canvas x = new canvas(requireContext());
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        clockwise = view.findViewById(R.id.left);
        anticlockwise = view.findViewById(R.id.right);
        cancel = view.findViewById(R.id.cancel);

       /* clockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (res.getGrid()[res.getTouchrow()][res.getTouchcolumn()]) {
                    case 2:
                        res.getGrid()[res.getTouchrow()][res.getTouchcolumn()]=1;;
                        break;
                    case 22:
                        res.getGrid()[res.getTouchrow()][res.getTouchcolumn()]=21;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        typeselected = 1;
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        typeselected = 3;
                        break;
                    case 13:
                    case 14:
                    case 33:
                    case 34:
                        typeselected = 4;
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                        typeselected = 2;
                        break;
                    default:
                        typeselected = 0;
                }
            }
        });

        anticlockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (res.getGrid()[res.getTouchrow()][res.getTouchcolumn()]) {
                    case 1:
                    case 2:
                    case 21:
                    case 22:
                        typeselected = 5;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        typeselected = 1;
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        typeselected = 3;
                        break;
                    case 13:
                    case 14:
                    case 33:
                    case 34:
                        typeselected = 4;
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                        typeselected = 2;
                        break;
                    default:
                        typeselected = 0;
                }
            }
        });
*/

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.getSelected().setValue(false);
            }
        });


        selected = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if (aBoolean) {
                    if (res.isClockwise())
                        clockwise.setVisibility(View.VISIBLE);
                    if (res.isAnticlockwise())
                        anticlockwise.setVisibility(View.VISIBLE);
                } else {
                    clockwise.setVisibility(View.GONE);
                    anticlockwise.setVisibility(View.GONE);
                }
            }
        };
        res.getSelected().observe(requireActivity(), selected);


    }
}
