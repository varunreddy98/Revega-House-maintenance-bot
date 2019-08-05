// Generated code from Butter Knife. Do not modify!
package com.hariofspades.chatbot.CCFragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.droidmentor.checkoutflow.Utils.CreditCardEditText;
import com.hariofspades.chatbot.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CCNumberFragment_ViewBinding implements Unbinder {
  private CCNumberFragment target;

  @UiThread
  public CCNumberFragment_ViewBinding(CCNumberFragment target, View source) {
    this.target = target;

    target.et_number = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'et_number'", CreditCardEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CCNumberFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et_number = null;
  }
}
