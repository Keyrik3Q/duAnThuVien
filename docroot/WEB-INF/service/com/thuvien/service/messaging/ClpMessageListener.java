/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.thuvien.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.thuvien.service.ClpSerializer;
import com.thuvien.service.GiaHanLocalServiceUtil;
import com.thuvien.service.GiaHanServiceUtil;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.PhieuMuonServiceUtil;
import com.thuvien.service.PhuongThanhPhoLocalServiceUtil;
import com.thuvien.service.PhuongThanhPhoServiceUtil;
import com.thuvien.service.QuanThanhPhoLocalServiceUtil;
import com.thuvien.service.QuanThanhPhoServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;
import com.thuvien.service.SachServiceUtil;
import com.thuvien.service.TheLoaiLocalServiceUtil;
import com.thuvien.service.TheLoaiServiceUtil;
import com.thuvien.service.TinhThanhPhoLocalServiceUtil;
import com.thuvien.service.TinhThanhPhoServiceUtil;

/**
 * @author ADMIN
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			GiaHanLocalServiceUtil.clearService();

			GiaHanServiceUtil.clearService();
			PhieuMuonLocalServiceUtil.clearService();

			PhieuMuonServiceUtil.clearService();
			PhuongThanhPhoLocalServiceUtil.clearService();

			PhuongThanhPhoServiceUtil.clearService();
			QuanThanhPhoLocalServiceUtil.clearService();

			QuanThanhPhoServiceUtil.clearService();
			SachLocalServiceUtil.clearService();

			SachServiceUtil.clearService();
			TheLoaiLocalServiceUtil.clearService();

			TheLoaiServiceUtil.clearService();
			TinhThanhPhoLocalServiceUtil.clearService();

			TinhThanhPhoServiceUtil.clearService();
		}
	}
}