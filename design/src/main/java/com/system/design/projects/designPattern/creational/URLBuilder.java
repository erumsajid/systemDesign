package com.system.design.projects.designPattern.creational;

public class URLBuilder {
    String protocol;
    String host;
    String port;

    private URLBuilder(builder builder){
        this.protocol=builder.protocol;
        this.host = builder.host;
        this.port = builder.port;
    }

    @Override
    public String toString() {
        return "URLBuilder{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

    public static class builder{
        String protocol;
        String host;
        String port;

        public builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public builder setHost(String host) {
            this.host = host;
            return this;
        }

        public builder setPort(String port) {
            this.port = port;
            return this;
        }

        public URLBuilder build(){
            return new URLBuilder(this);
        }
    }

}
