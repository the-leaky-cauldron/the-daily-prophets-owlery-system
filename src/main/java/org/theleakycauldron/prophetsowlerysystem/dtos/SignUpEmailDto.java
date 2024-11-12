package org.theleakycauldron.prophetsowlerysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class SignUpEmailDto implements Serializable {
    private String name;
    private String email;
}
