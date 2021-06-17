package com.summer.springvuedemo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maindata {

  private Integer id;
  private Integer year;
  private Integer month;
  private Integer day;
  private Integer areaId;
  private String areaName;
  private Integer nowConfirm;
  private Integer nowConfirmAdd;
  private Integer noInfect;
  private Integer noInfectAdd;
  private Integer suspect;
  private Integer suspectAdd;
  private Integer nowSevere;
  private Integer nowSevereAdd;
  private Integer totalConfirm;
  private Integer totalConfirmAdd;
  private Integer imported;
  private Integer importedAdd;
  private Integer heal;
  private Integer healAdd;
  private Integer dead;
  private Integer deadAdd;


}
