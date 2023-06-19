## Project Structure
* buildSrc: gradle build configuration, common build tasks 
* config-repo: the file location for storing applications' configurations, used by ConfigureServer
* ServiceGroup2: Product is the backend internal service  (service provider)
* ServiceGroup2: ProductComposite is composite service for using backend internal services (consumer)
* SpringCLoud: Gateway\
add Erureka client to register its to registry center (Eureka)\
add Sentinel for service control
* SpringCloud: OpenFeinServiceInvoker is the consumer of backend service product\
add Config client to use central configuration from ConfigServer\
add Erureka client to register its to registry center (Eureka)\
add Sentinel for service control

## Overview Architecture