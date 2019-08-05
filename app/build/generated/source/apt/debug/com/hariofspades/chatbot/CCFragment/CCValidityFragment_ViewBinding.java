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

public class CCValidityFragment_ViewBinding implements Unbinder {
  private CCValidityFragment target;

  @UiThread
  public CCValidityFragment_ViewBinding(CCValidityFragment target, View source) {
    this.target = target;

    target.et_validity = Utils.findRequiredViewAsType(source, R.id.et_validity, "field 'et_validity'", CreditCardEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CCValidityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et_validity = null;
  }
}
