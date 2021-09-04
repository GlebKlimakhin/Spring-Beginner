package ru.gb.current;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.prev.CartConfiguration;

@Configuration
@Import(CartConfiguration.class)
public class RootWebApplicationConfig{
}
