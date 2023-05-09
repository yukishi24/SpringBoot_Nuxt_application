package com.example.demo.form;

import jakarta.validation.GroupSequence;

/**
 * バリテーションの順番を実装するインターフェース
 * 
 * @author yukishi
 *
 */
@GroupSequence({ValidGroup1.class,ValidGroup2.class})
public interface GroupOrder {

}
