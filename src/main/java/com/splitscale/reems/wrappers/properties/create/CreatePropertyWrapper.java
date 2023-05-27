package com.splitscale.reems.wrappers.properties.create;

import com.splitscale.reems.properties.PropertyRequest;
import com.splitscale.reems.properties.create.CreatePropertyInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreatePropertyWrapper {

  private CreatePropertyInteractor interactor;

  public CreatePropertyWrapper(CreatePropertyInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(PropertyRequest propertyRequest)
    throws IOException, GeneralSecurityException {
    return interactor.createProperty(propertyRequest);
  }
}
