package com.splitscale.reems.security.wrappers.properties.edit;

import com.splitscale.reems.properties.Property;
import com.splitscale.reems.properties.edit.EditPropertyInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditPropertyWrapper {

  private EditPropertyInteractor interactor;

  public EditPropertyWrapper(EditPropertyInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(Property property)
    throws IOException, GeneralSecurityException {
    interactor.editProperty(property);
  }
}
