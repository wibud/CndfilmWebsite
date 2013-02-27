<?xml version="1.0" encoding="UTF-8" ?>

<!-- 如果你看不懂，说明你需要学习一下XSLT，去http://www.w3school.com.cn/学习下吧  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<!-- 表示输出为XML -->
	<xsl:output method="xml"/>

	<!-- 匹配到XML的根节点，现在相当于就按原始格式输出，以后有需要可以更改  -->
	<xsl:template match="/result">
		<result>
			<xsl:copy-of select="child::*"></xsl:copy-of>
		</result>
	</xsl:template>
	

</xsl:stylesheet>
