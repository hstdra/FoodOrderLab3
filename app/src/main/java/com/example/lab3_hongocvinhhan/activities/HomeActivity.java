package com.example.lab3_hongocvinhhan.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.adapters.FoodHomeAdapter;
import com.example.lab3_hongocvinhhan.databases.FoodService;

public class HomeActivity extends MenuActivity {
    private ListView foodListView;
    private FoodService foodService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //        this.deleteDatabase(DatabaseHelper.DATABASE_NAME);
        foodListView = findViewById(R.id.foodList);

        foodService = new FoodService(this);

        if (foodService.getFoods().isEmpty()) {
            foodService.addFood("Thịt chó", 60000, "https://image.plo.vn/w653/Uploaded/2020/xqeioxmrke/2020_02_14/thitchodd_rizf.jpg");
            foodService.addFood("Thịt chuột", 65000, "https://image.anninhthudo.vn/w700/uploaded/170/2020_01_19/thit-chuot.jpg");
            foodService.addFood("Thịt rắn", 65000, "https://afamilycdn.com/8LcFe7IIQPcMZ8b2lnpwHX5vzDNQ2b/Image/2011/10/171011AfamilyDLran3_af34e.jpg");
            foodService.addFood("Thịt tắc kè", 79000, "https://suckhoedoisong.vn/Images/duylinh/2016/04/07/tac-ke-tri-xuat-tinh-som.jpg");
            foodService.addFood("Thịt dơi", 69000, "https://image.tinnhanhchungkhoan.vn/w660/Uploaded/2020/gtnwae/2019_11_30/newfolder/z-b_rkpn.jpg");
        }

        FoodHomeAdapter adapter = new FoodHomeAdapter(this, R.layout.food_row, foodService.getFoods());
        foodListView.setAdapter(adapter);
    }
}