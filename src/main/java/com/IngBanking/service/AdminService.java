package com.IngBanking.service;

import java.util.List;

import com.IngBanking.dto.ApprovalDTO;

public interface AdminService {



	ApprovalDTO adminApproval(Long accountId, String status);

	List<ApprovalDTO> getallusersList();

}
