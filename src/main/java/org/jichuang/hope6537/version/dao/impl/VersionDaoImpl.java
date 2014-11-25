package org.jichuang.hope6537.version.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.version.dao.VersionDao;
import org.jichuang.hope6537.version.model.Version;
import org.springframework.stereotype.Repository;

@Repository("versionDao")
public class VersionDaoImpl extends BaseDaoImpl<Version> implements VersionDao {

}
