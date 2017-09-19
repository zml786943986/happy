package com.cn.hnust.util;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
/**
 * mybatis 实现分页拦截器
 * 
 * @author Thinkpad
 *
 */
@Component
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class SqlPageInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,new DefaultObjectFactory() , new DefaultObjectWrapperFactory());
		RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");
		if (rowBounds == null ||Integer.MAX_VALUE==rowBounds.getLimit()) {
			return invocation.proceed();
		}
		String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
		StringBuffer sqlSb = new StringBuffer(originalSql);
		sqlSb.append(" limit ").append(rowBounds.getOffset())
		.append(" , ").append(rowBounds.getLimit());
		//设置分页参数
		metaStatementHandler.setValue("delegate.boundSql.sql", sqlSb.toString());
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}
}
