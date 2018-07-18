package software.aws.toolkits.jetbrains.core.credentials

import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.aws.toolkits.core.credentials.ToolkitCredentialsProvider
import software.aws.toolkits.jetbrains.core.region.AwsRegionProvider

class MockProjectAccountSettingsManager : ProjectAccountSettingsManager {
    override fun credentialProviders(): List<ToolkitCredentialsProvider> = emptyList()

    override var activeRegion = AwsRegionProvider.getInstance().defaultRegion()

    override var activeCredentialProvider = object : ToolkitCredentialsProvider {
        override val id = "MockCredentials"
        override val displayName = " Mock Credentials"

        override fun getCredentials(): AwsCredentials = AwsCredentials.create("Foo", "Bar")
    }
}