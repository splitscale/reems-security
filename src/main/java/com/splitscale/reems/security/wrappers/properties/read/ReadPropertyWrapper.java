package com.splitscale.reems.security.wrappers.properties.read;

import com.splitscale.reems.properties.Property;
import com.splitscale.reems.properties.read.ReadPropertyInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadPropertyWrapper {

  private ReadPropertyInteractor interactor;

  public ReadPropertyWrapper(ReadPropertyInteractor interactor) {
    this.interactor = interactor;
  }

  public List<Property> getProperty()
    throws IOException, GeneralSecurityException {
    return interactor.getAllProperty();
  }

  public Property getPropertyId(String id)
    throws IOException, GeneralSecurityException {
    return interactor.getById(id);
  }
}
