package com.wirebarley.work.commons;

import com.wirebarley.work.handler.aop.ValidationAdvice;

import java.lang.annotation.*;

/**
 * Api Valid Annotation
 * @see  ValidationAdvice
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiValidationAdvice {
}
