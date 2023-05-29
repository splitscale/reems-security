package com.splitscale.reems.wrappers.hazardStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.hazardStats.HazardStats;
import com.splitscale.reems.hazardStats.read.ReadHazardStatsInteractor;

public class ReadHazardStatsWrapper {
  private ReadHazardStatsInteractor interactor;

  public List<HazardStats> getAllHazardStats()
      throws IOException, GeneralSecurityException {
    return interactor.getAllHazardStats();
  }

  public HazardStats getHazardStatsById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getHazardStatsById(id);
  }
}
