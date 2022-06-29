<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match = "/class">
	<html>
		<body>
			<h2>Patient Details</h2>			
			<table border = "1">
				<tr>
					<th>Name</th>
					<th>Age</th>					 
				</tr>				
				<xsl:for-each select = "patient">				
					<tr>
						<td><xsl:value-of select = "Name"/></td>
						<td><xsl:value-of select = "Age"/></td>						 
					</tr>				
				</xsl:for-each>				
			</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>