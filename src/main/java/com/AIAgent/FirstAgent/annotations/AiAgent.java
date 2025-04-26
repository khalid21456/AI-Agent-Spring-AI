package com.AIAgent.FirstAgent.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("unused")

// Créer une annotation AI Agent qui équivalent à l'annotation Component
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface AiAgent {
    @AliasFor(annotation = Component.class)
    public String value() default "";

}
