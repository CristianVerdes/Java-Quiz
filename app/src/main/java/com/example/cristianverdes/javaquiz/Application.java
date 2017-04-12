package com.example.cristianverdes.javaquiz;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Cristian Verdes on 4/12/2017.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Roboto/Roboto-Italic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
