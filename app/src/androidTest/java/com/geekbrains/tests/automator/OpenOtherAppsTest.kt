package com.geekbrains.tests.automator

import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class OpenOtherAppsTest {

    private val uiDevice: UiDevice = UiDevice.getInstance(getInstrumentation())

    @Test
    fun `Open_Settings_My_SamsungA8_SM-A530F`() {
        if (!uiDevice.isScreenOn) uiDevice.wakeUp()
        uiDevice.pressHome()
        uiDevice.swipe(500, 1500, 500, 0, 5)
        val settingsApp = uiDevice.findObject(By.text("Настройки"))
        settingsApp.click()
        val settingsMenuList = UiScrollable(UiSelector().scrollable(true))
        val updateMenu = settingsMenuList.getChildByText(
            UiSelector().className(TextView::class.java.name), "Обновление ПО"
        )
        updateMenu.clickAndWaitForNewWindow()
        val checkUpdate = uiDevice.findObject(By.text("Загрузка и установка"))
        checkUpdate.click()
    }
}
