Channel Interceptor

WebSecurityConfigurerAdapter
    - Provides HttpSecurity configurations to configure cors, crsf, session management, rules for protected resources.
    
UserDetailsService interface has a method to load User by username & returns UserDetails object that Spring security can use for authentication & validation

UsernamePasswordAuthenticationToken gets username, password from loging request


OncePerRequestFiler makes a single execution for each request to our API, provides
    doFilterInternal() method that we will implement parsing & validating JWT, loading User details
    
    
    
UserDetailsImpl


AuthenticationEntryPoint    


authentication and access control functionalit yis typically implemented as filters that sit in front of the main application servlets.

When a request is dispatched using a request dispatcher, it has to go through the filter chain again before it ets to the servlet.

GrantedAuthority -> individual privilege.

examples include READ_AUTHORITY, WRITE_PRIVILEGE CAN_EXECUTE_AS_ROOT,name is arbitrary