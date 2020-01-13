package com.jterra.worldheritages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jterra.worldheritages.Common.Utils
import com.livefront.bridge.Bridge

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Bridge.restoreInstanceState(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Bridge.saveInstanceState(this, outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bridge.clear(this)
    }
}
