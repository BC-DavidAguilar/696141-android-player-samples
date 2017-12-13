
package com.brightcove.player.samples.onceux.basic.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * Provide a class to provide test cases.
 */
public class UiAutomatorTest extends UiAutomatorTestCase {

    // Private class constants

    // For Logcat.
    private final String TAG = this.getClass().getSimpleName();

    // Public methods.

    public void testDemo() throws UiObjectNotFoundException {   
      
      // Simulate a short press on the HOME button.
      getUiDevice().pressHome();
      
      // We’re now in the home screen. Next, we want to simulate 
      // a user bringing up the All Apps screen.
      // If you use the uiautomatorviewer tool to capture a snapshot 
      // of the Home screen, notice that the All Apps button’s 
      // content-description property has the value “Apps”.  We can 
      // use this property to create a UiSelector to find the button. 
      UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
      
      // Simulate a click to bring up the All Apps screen.
      allAppsButton.clickAndWaitForNewWindow();
      
      // In the All Apps screen, the Settings app is located in 
      // the Apps tab. To simulate the user bringing up the Apps tab,
      // we create a UiSelector to find a tab with the text 
      // label “Apps”.
      UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
      
      // Simulate a click to enter the Apps tab.
      appsTab.click();

      // Next, in the apps tabs, we can simulate a user swiping until
      // they come to the Settings app icon.  Since the container view 
      // is scrollable, we can use a UiScrollable object.
      UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
      
      // Set the swiping mode to horizontal (the default is vertical)
      appViews.setAsHorizontalList();
      
      // Create a UiSelector to find the Settings app and simulate      
      // a user click to launch the app. 
      UiObject calendarApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "Calendar");
      
      // Validate that the calendar app exists.
      assertTrue("Unable to detect Calendar app.", calendarApp != null);
      calendarApp.clickAndWaitForNewWindow();
  }   

}
