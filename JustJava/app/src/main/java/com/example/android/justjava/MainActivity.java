/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

 package com.example.android.justjava;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.CheckBox;
 import android.widget.EditText;
 import android.widget.TextView;

 import org.w3c.dom.Text;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    double coffeePrice = 3.5;
    boolean isChecked = false;
    double creamPrice = 1.0;
    double chocolatePrice = 1.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addOne(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int oldNumber = Integer.parseInt(quantityTextView.getText().toString());
        oldNumber++;
        quantityTextView.setText("" + oldNumber);
       // displayPrice(oldNumber * 3.5);
      //  submitOrder(view);
    }

    public void removeOne(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int oldNumber = Integer.parseInt(quantityTextView.getText().toString());

        if (oldNumber == 0) return;
        oldNumber--;
        quantityTextView.setText("" + oldNumber);
        //displayPrice(String.valueOf(oldNumber * 3.5));
     //   submitOrder(view);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText(message);
    }

    private String createOrderSummery(double price, String name) {
        String message;

        if (isChecked) {
            message = "\nName: " + name + "\nAdding Whipped Cream" + "\nTotal: $" + price;
        } else {
            message = "\nName: " + name + "\nTotal: $" + price;
        }
        return message;
    }

    private double calculatePrice(int number) {
        double price = 0;
        CheckBox creamBox = findViewById(R.id.checkbox_cream);
        boolean hasCream = creamBox.isChecked();
        CheckBox chocoBox = findViewById(R.id.checkbox_chocolate);
        boolean hasChoco = chocoBox.isChecked();

        if (hasChoco && hasCream) {
            price = number * coffeePrice + creamPrice + chocolatePrice;
        } else if (hasChoco) {
            price = number * coffeePrice + chocolatePrice;
        } else if (hasCream) {
            price = number * coffeePrice + creamPrice;
        } else {
            price = number * coffeePrice;
        }
        return price;
    }

    public void submitOrder(View v) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int number = Integer.parseInt(quantityTextView.getText().toString());

        double price = calculatePrice(number);
        EditText nameView = findViewById(R.id.name);
        String name = nameView.getText().toString();
        String message = createOrderSummery(price, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java coffee order");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
      //  displayPrice(message);

    }

    public void onCheckboxClicked(View v) {
        isChecked = !isChecked;
    }
}