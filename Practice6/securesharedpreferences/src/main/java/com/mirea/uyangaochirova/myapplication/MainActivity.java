package com.mirea.uyangaochirova.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;

        try {
            String mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);

            SharedPreferences secureSharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            secureSharedPreferences.edit().putString("secure", "ЛЮБИМЫЙ ПИСАТЕЛЬ");
            String result = secureSharedPreferences.getString("secure", "ЛЮБИМЫЙ ПИСАТЕЛЬ");
        }
        catch	(GeneralSecurityException	|	IOException	e)	{
            throw	new	RuntimeException(e);
        }


    }
}