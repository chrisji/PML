<html> 
	<h1>
		<if cond="true">
			<then><p>Hello world!</p></then>
			<elif cond="false">else if branch!</elif>
			<else>else branch!</else>
		</if>
	</h1>
	<p>This is the paragraph</p>
	<esc><![CDATA[<?php echo '<hello>php stuff</hello>'; ?>]]></esc>
	<img/>
	<while cond="true">
		<p>To infinity and beyond!</p>
	</while>
	<!-- Comment will be ignored -->	
	
	<function name="myFunc">
		<argument name="$arg1"/>
		<argument name="$arg2"/>
		<argument name="$arg3"/>
		<argument name="$arg4"/>
		<body>Hello World.</body>
		<notBody>not shown</notBody>
	</function>
</html>
