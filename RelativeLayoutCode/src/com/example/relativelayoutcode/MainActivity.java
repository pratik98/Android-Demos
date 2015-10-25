package com.example.relativelayoutcode;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	RelativeLayout main;
	TextView message, userName, password;
	EditText userNameValue, passwordValue;
	Button login;
	LayoutParams mainDimensions, messageDimensions, userNameDimensions,
			passwordDimensions, userNameValueDimensions,
			passwordValueDimensions, loginDimensions;
	int messageID = 1, userNameID = 2, passwordID = 3, userNameValueID = 4,
			passwordValueID = 5, loginID = 6;
	int paddingValue = 10, marginValue = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		layout();
		textView();
		editTextView();
		buttonView();

		main.addView(message, messageDimensions);
		main.addView(userName, userNameDimensions);
		main.addView(password, passwordDimensions);
		main.addView(userNameValue, userNameValueDimensions);
		main.addView(passwordValue, passwordValueDimensions);
		main.addView(login, loginDimensions);

		setContentView(main);
	}

	private void buttonView() {
		loginDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		loginDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		loginDimensions.addRule(RelativeLayout.BELOW, passwordValueID);
		login.setTextColor(Color.WHITE);
		login.setBackgroundColor(Color.GRAY);
		login.setId(loginID);
		login.setText("Login");
		// login.setLayoutParams(loginDimensions);
	}

	private void editTextView() {
		userNameValueDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		userNameValueDimensions.addRule(RelativeLayout.RIGHT_OF, userNameID);
		userNameValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		userNameValueDimensions.addRule(RelativeLayout.BELOW, messageID);
		userNameValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE,
				userNameID);
		userNameValue.setBackgroundColor(Color.GREEN);
		userNameValueDimensions.setMargins(0, 0, 0, marginValue);
		userNameValue.setId(userNameValueID);
		// userNameValue.setLayoutParams(passwordValueDimensions);

		passwordValueDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		passwordValueDimensions.addRule(RelativeLayout.RIGHT_OF, passwordID);
		passwordValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		passwordValueDimensions.addRule(RelativeLayout.BELOW, userNameValueID);
		passwordValue.setBackgroundColor(Color.YELLOW);
		passwordValueDimensions.setMargins(0, 0, 0, marginValue);
		passwordValue.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD
				| InputType.TYPE_NUMBER_VARIATION_PASSWORD);
		passwordValue.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
		passwordValue.setId(passwordValueID);
		// passwordValue.setLayoutParams(passwordValueDimensions);
	}

	private void layout() {
		mainDimensions = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		main.setBackgroundColor(Color.BLACK);
		main.setLayoutParams(mainDimensions);
	}

	private void textView() {
		messageDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		messageDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		message.setText("Please Login First");
		messageDimensions.setMargins(paddingValue, 100, paddingValue,
				paddingValue);
		message.setId(messageID);
		message.setTextColor(Color.WHITE);
		// message.setLayoutParams(messageDimensions);

		userNameDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		userNameDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		userNameDimensions.addRule(RelativeLayout.BELOW, messageID);
		userName.setText("User Name");
		userName.setId(userNameID);
		userName.setPadding(paddingValue, paddingValue, paddingValue,
				paddingValue);
		userName.setTextColor(Color.WHITE);
		// userName.setLayoutParams(userNameDimensions);

		passwordDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		passwordDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		passwordDimensions.addRule(RelativeLayout.BELOW, userNameID);
		passwordDimensions.addRule(RelativeLayout.ALIGN_RIGHT, userNameID);
		password.setGravity(Gravity.RIGHT);
		password.setText("Password");
		password.setId(passwordID);
		password.setTextColor(Color.WHITE);
		password.setPadding(paddingValue, paddingValue, paddingValue,
				paddingValue);
		// password.setLayoutParams(passwordDimensions);
	}

	private void init() {
		main = new RelativeLayout(this);
		message = new TextView(this);
		userName = new TextView(this);
		password = new TextView(this);
		userNameValue = new EditText(this);
		passwordValue = new EditText(this);
		login = new Button(this);
	}
}