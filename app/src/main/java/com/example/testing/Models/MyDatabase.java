package com.example.testing.Models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.testing.Api.Api_Panier.CartDao;
import com.example.testing.Models.Cart;

@Database(entities={Cart.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract CartDao cartDao();
}
