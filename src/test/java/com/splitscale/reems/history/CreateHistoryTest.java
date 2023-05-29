package com.splitscale.reems.history;

import com.splitscale.reems.core.history.HistoryRequest;
import com.splitscale.reems.core.history.create.CreateHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.history.create.CreateHistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateHistoryTest {

  @Mock
  private CreateHistoryInteractor interactor;

  @Mock
  private SecurityService securityService;

  private CreateHistory wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new CreateHistory(securityService, interactor);
  }

  @Test
  public void testCreateHistory() throws IOException, GeneralSecurityException {
    // Arrange
    HistoryRequest historyRequest = new HistoryRequest("Event 1", "History Body");
    String jwtToken = "jwtToken";
    String userId = "userId";
    String expectedId = "123";

    when(interactor.createHistory(historyRequest)).thenReturn(expectedId);

    // Act
    String actualId = wrapper.create(historyRequest, jwtToken, userId);

    // Assert
    assertEquals(expectedId, actualId);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createHistory(historyRequest);
  }
}
