/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.youmeek.ssm.module.rpc;


import org.apache.thrift.TEnum;

/**
 * **************************************************************************************************
 *  定义返回值，
 *  枚举类型ThriftResult，表示返回结果，成功或失败，如果失败，还可以表示失败原因
 *  每种返回类型都对应一个封装的结构体，该结构体其命名遵循规则："Result" + "具体操作结果类型"，结构体都包含两部分内容：
 *  第一部分为枚举类型ThriftResult变量result，表示操作结果,可以 表示成功，或失败，失败时可以给出失败原因
 *  第二部分为枚举类型Action变量value，表示操作动作类型；
 * ***************************************************************************************************
 */
public enum ThriftResult implements TEnum {
  SUCCESS(0),
  PARAMETER_ERROR(1),
  EXCEPTION(2),
  UNKNOWN_ERROR(3);

  private final int value;

  private ThriftResult(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ThriftResult findByValue(int value) {
    switch (value) {
      case 0:
        return SUCCESS;
      case 1:
        return PARAMETER_ERROR;
      case 2:
        return EXCEPTION;
      case 3:
        return UNKNOWN_ERROR;
      default:
        return null;
    }
  }
}
