package com.splitscale.reems.history;

import com.splitscale.reems.core.history.History;
import com.splitscale.reems.core.history.edit.EditHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.history.edit.EditHistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditHistoryTest {

  @Mock
  private EditHistoryInteractor interactor;

  @Mock
  private SecurityService securityService;

  private EditHistory wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditHistory(securityService, interactor);
  }

  @Test
  public void testEditHistory() throws IOException, GeneralSecurityException {
    // Arrange
    History history = new History("123", "History 1", "History Body", null);

    // Act
    wrapper.edit(history, "jwtToken", "userId");

    // Assert
    verify(securityService, times(1)).validateJwt("jwtToken", "userId");
    verify(interactor, times(1)).editHistory(history);
  }
}
