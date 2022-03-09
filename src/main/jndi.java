package be.pvgroup.webservice.telebib.config.properties;

import java.util.Properties;
import java.util.TimeZone;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("managed")
public class ManagedPropertyConfig extends PropertyConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagedPropertyConfig.class);

	private static final String JNDI_CONTEXT_ENVIRONMENT = "java:comp/env1";
	private static final String JNDI_DOC_IN_FOLDER_JNDI_PROPERTY_NAME = "ws-telebib/cbtg/gfs/doc/in33";
	private static final String JNDI_DOC_TIMEOUT_FOLDER_JNDI_PROPERTY_NAME = "ws-telebib/cbtg/gfs/doc/timeout";
	private static final String JNDI_FTP_IN_FOLDER_JNDI_PROPERTY_NAME = "ws-telebib/cbtg/gfs/ftp/in";
	private static final String API_KEY_JNDI = "ws-telebib/jwt/apikey";
	private static final String API_SECRET_JNDI = "ws-telebib/jwt/secret";
	private static final String API_EDIMERX_URL_JNDI = "ws-telebib/service/portima/rootUrl";
	private static final String API_AUTHENTICATION_URL_JNDI = "ws-telebib/service/portima/authentication/rootUrl";
	private static final String API_CONVERT_URL_JNDI = "ws-telebib/service/portima/convert/rootUrl";
	private static final String PROPERTY_ENVIRONMENT = "environment";
	private static final String LOCAL_ENVIRONMENT = "localhost";

	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();

		try {
			Context jndiContext = (Context) new InitialContext().lookup(JNDI_CONTEXT_ENVIRONMENT);
			addJNDIProperties(properties, jndiContext);
			addEnvironmentProperties(properties);
		} catch (NamingException e) {
			throw new FatalApplicationException("Can't retrieve JNDI configuration: ", e);
		}

		return properties;
	}

	private void addJNDIProperties(Properties properties, Context jndiContext) throws NamingException {
		properties.setProperty(DOC_INPUT_FOLDER_PROPERTY_NAME, (String) jndiContext.lookup(JNDI_DOC_IN_FOLDER_JNDI_PROPERTY_NAME));
		properties.setProperty(DOC_TIMEOUT_FOLDER_PROPERTY_NAME, (String) jndiContext.lookup(JNDI_DOC_TIMEOUT_FOLDER_JNDI_PROPERTY_NAME));
		properties.setProperty(FTP_INPUT_FOLDER_PROPERTY_NAME, (String) jndiContext.lookup(JNDI_FTP_IN_FOLDER_JNDI_PROPERTY_NAME));
		properties.setProperty(API_KEY_NAME, (String) jndiContext.lookup(API_KEY_JNDI));
		properties.setProperty(API_SECRET_NAME, (String) jndiContext.lookup(API_SECRET_JNDI));
		properties.setProperty(API_EDIMERX_URL, (String) jndiContext.lookup(API_EDIMERX_URL_JNDI));
		properties.setProperty(API_AUTHENTICATION_URL, (String) jndiContext.lookup(API_AUTHENTICATION_URL_JNDI));
		properties.setProperty(API_CONVERT_URL, (String) jndiContext.lookup(API_CONVERT_URL_JNDI));

		LOGGER.info("document input folder" + (String) jndiContext.lookup(JNDI_DOC_IN_FOLDER_JNDI_PROPERTY_NAME));
		LOGGER.info("API_KEY_NAME" + (String) jndiContext.lookup(API_KEY_JNDI));
		LOGGER.info("API_KEY_NAME in prop" + properties.getProperty(API_KEY_NAME));
		LOGGER.info("API_SECRET_NAME" + (String) jndiContext.lookup(API_SECRET_JNDI));
		LOGGER.info("Default Timezone:"+TimeZone.getDefault());

	}

	private void addEnvironmentProperties(Properties properties) {
		properties.setProperty(ENVIRONMENT_PROPERTY_NAME, getEnvironment());
	}

	private String getEnvironment() {
		String environment = System.getProperty(PROPERTY_ENVIRONMENT);
		if (environment == null) {
			return LOCAL_ENVIRONMENT;
		} else {
			return environment;
		}
	}

}
