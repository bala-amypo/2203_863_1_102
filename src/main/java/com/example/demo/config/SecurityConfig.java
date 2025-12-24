http
    .csrf().disable()
    .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(
            "/auth/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/webjars/**",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security"
        ).permitAll()
        .anyRequest().authenticated()
    );
