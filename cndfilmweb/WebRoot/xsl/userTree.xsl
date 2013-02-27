<?xml version="1.0" encoding="UTF-8" ?>

<!-- 如果你看不懂，说明你需要学习一下XSLT，去http://www.w3school.com.cn/学习下吧  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<!-- 表示输出为XML -->
	<xsl:output method="xml"/>

	<!-- 匹配到XML的根节点，现在相当于就按原始格式输出，以后有需要可以更改  -->
	<xsl:template match="/result">
		<result>
			
			<xsl:for-each select="*">
				<item>
					<xsl:call-template name="filter">
						<xsl:with-param name="id" select="id"></xsl:with-param>
						<xsl:with-param name="name" select="name"></xsl:with-param>
						<xsl:with-param name="type" select="type"></xsl:with-param>
						<xsl:with-param name="childList" select="childList/child::*"></xsl:with-param>
					</xsl:call-template>
				</item>
			</xsl:for-each>
				
		</result>
	</xsl:template>
	
	<xsl:template name="filter">
		<xsl:param name="id"></xsl:param>
		<xsl:param name="name"></xsl:param>
		<xsl:param name="type"></xsl:param>
		<xsl:param name="childList"></xsl:param>
		
		<xsl:copy-of select="$id"></xsl:copy-of>
		<xsl:copy-of select="$name"></xsl:copy-of>
		<xsl:copy-of select="$type"></xsl:copy-of>
		<xsl:for-each select="$childList">
			<item>
				<xsl:call-template name="filter">
					<xsl:with-param name="id" select="id"></xsl:with-param>
					<xsl:with-param name="name" select="name"></xsl:with-param>
					<xsl:with-param name="type" select="type"></xsl:with-param>
					<xsl:with-param name="childList" select="childList/child::*"></xsl:with-param>
				</xsl:call-template>
			</item>
		</xsl:for-each>
		
		
	</xsl:template>
	

</xsl:stylesheet>
