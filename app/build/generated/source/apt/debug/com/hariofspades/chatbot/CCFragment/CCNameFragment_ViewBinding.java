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

public class CCNameFragment_ViewBinding implements Unbinder {
  private CCNameFragment target;

  @UiThread
  public CCNameFragment_ViewBinding(CCNameFragment target, View source) {
    this.target = target;

    target.et_name = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'et_name'", CreditCardEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CCNameFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et_name = null;
  }
}
