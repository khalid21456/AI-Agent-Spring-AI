package com.AIAgent.FirstAgent.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")

// Créer une annotation AI Agent qui équivalent à l'annotation Component

@Component
public @interface AiAgent {
    @AliasFor(annotation = Component.class)
    public String value() default "";

}
