/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 26, 2022
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Game;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Game game() {
		Game bean = new Game("Place Holder");
		return bean;
	}
}
