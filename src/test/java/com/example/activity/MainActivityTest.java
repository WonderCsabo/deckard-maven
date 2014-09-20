package com.example.activity;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.app.Activity;

@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
@PrepareForTest(Static.class)
public class MainActivityTest {
	
  @Rule
  public PowerMockRule rule = new PowerMockRule();

  @org.junit.Test
  public void titleIsCorrect() throws Exception {
    Activity activity = Robolectric.setupActivity(MainActivity.class);
    assertTrue(activity.getTitle().toString().equals("Deckard"));
  }
  
  @org.junit.Test
  public void testStaticMocking() {
	  PowerMockito.mockStatic(Static.class);
	  Mockito.when(Static.staticMethod()).thenReturn("hello mock");
	  
	  assertTrue(Static.staticMethod().equals("hello mock"));
  }
}
