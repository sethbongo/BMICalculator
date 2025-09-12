package com.example.activity2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    TextView loseWeight;
    TextView gainWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        EditText result = findViewById(R.id.bmi_result);
        TextView category = findViewById(R.id.textView4);
        loseWeight = findViewById(R.id.lose_weight);
        gainWeight = findViewById(R.id.gain_weight);
        Button btn = findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {

                String weightInput = weight.getText().toString();
                String heightInput = height.getText().toString();

                if (!weightInput.isEmpty() && !heightInput.isEmpty()){
                    float fweight = Float.parseFloat(weightInput);
                    float fheight = Float.parseFloat(heightInput);


                    BMICalculator BMIInstance = new BMICalculator(fheight, fweight);
                    float bmi = BMIInstance.calculate_bmi();

                    if (bmi == -1){
                        category.setText("Invalid!");
                        return;
                    }

                    String cate = BMIInstance.category(bmi);
////
                    result.setText(String.format(("%.5f"), bmi));
                    category.setText(cate);

                    loseWeight.setText(BMIInstance.getLowerBMI());
                    gainWeight.setText(BMIInstance.getHigherBMI());

                }else{
                    category.setText("Invalid Input! Try Again");
                }

            }
        });



    }

}