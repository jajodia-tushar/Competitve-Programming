package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input :
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5
         With 10 from A, 15 from B and 10 from C.
 */
public class Array3Pointers {

    public static void main(String[] args) {


        int[] A = ArrayUtils.asArrays(23, 54, 111, 122, 123, 140, 154, 193, 230, 236, 343, 349, 355, 364, 379, 381, 396, 399, 427, 461, 465, 472, 519, 571, 592, 593, 615, 616, 648, 649, 665, 666, 725, 785, 791, 834, 850, 866, 872, 876, 886, 915, 916, 932, 1013, 1016, 1025, 1058, 1088, 1092, 1108, 1201, 1249, 1272, 1460, 1466, 1472, 1480, 1520, 1522, 1524, 1530, 1530, 1531, 1576, 1582, 1588, 1603, 1664, 1710, 1738, 1751, 1763, 1805, 1806, 1815, 1818, 1828, 1842, 1855, 1868, 1913, 1914, 2025, 2060, 2112, 2113, 2156, 2165, 2185, 2206, 2219, 2220, 2222, 2222, 2245, 2263, 2295, 2316, 2325, 2348, 2352, 2370, 2430, 2464, 2473, 2501, 2505, 2524, 2531, 2560, 2562, 2563, 2569, 2579, 2617, 2667, 2670, 2768, 2773, 2810, 2868, 2870, 2894, 2923, 2927, 2979, 3020, 3022, 3029, 3038, 3041, 3059, 3074, 3092, 3138, 3154, 3156, 3260, 3268, 3285, 3305, 3335, 3362, 3373, 3379, 3383, 3393, 3409, 3463, 3467, 3492, 3498, 3527, 3529, 3574, 3621, 3648, 3683, 3724, 3744, 3751, 3757, 3786, 3796, 3817, 3822, 3823, 3908, 3986, 4019, 4123, 4128, 4164, 4203, 4204, 4253, 4259, 4260, 4282, 4307, 4316, 4317, 4367, 4369, 4442, 4456, 4481, 4486, 4488, 4499, 4515, 4541, 4543, 4562, 4582, 4587, 4608, 4627, 4635, 4666, 4695, 4696, 4736, 4757, 4793, 4817, 4830, 4835, 4890, 4914, 4929, 5067, 5067, 5114, 5135, 5148, 5158, 5195, 5209, 5217, 5286, 5295, 5297, 5317, 5350, 5366, 5367, 5381, 5404, 5473, 5492, 5501, 5523, 5536, 5540, 5544, 5557, 5589, 5649, 5658, 5732, 5750, 5789, 5808, 5849, 5882, 5889, 5892, 5917, 5922, 5925, 5973, 6008, 6063, 6085, 6094, 6114, 6132, 6152, 6184, 6193, 6201, 6208, 6210, 6241, 6249, 6253, 6257, 6275, 6313, 6334, 6344, 6401, 6402, 6404, 6427, 6453, 6460, 6484, 6492, 6509, 6518, 6531, 6532, 6592, 6605, 6619, 6634, 6673, 6732, 6745, 6762, 6782, 6802, 6821, 6827, 6836, 6901, 6918, 6964, 6966, 6968, 7049, 7075, 7083, 7138, 7157, 7193, 7232, 7239, 7318, 7356, 7362, 7405, 7416, 7425, 7443, 7487, 7491, 7517, 7572, 7616, 7626, 7659, 7673, 7704, 7709, 7712, 7730, 7742, 7747, 7759, 7856, 7859, 7875, 7882, 7887, 7888, 7888, 7899, 7961, 7992, 8014, 8035, 8111, 8117, 8117, 8127, 8135, 8178, 8179, 8217, 8252, 8277, 8293, 8301, 8305, 8327, 8373, 8379, 8380, 8387, 8390, 8402, 8404, 8404, 8404, 8417, 8439, 8443, 8449, 8484, 8503, 8514, 8525, 8539, 8539, 8572, 8585, 8601, 8617, 8617, 8630, 8636, 8660, 8693, 8714, 8724, 8745, 8767, 8778, 8783, 8870, 8871, 8897, 8949, 8975, 8993, 9000, 9015, 9049, 9050, 9088, 9092, 9127, 9139, 9142, 9195, 9198, 9285, 9385, 9405, 9439, 9464, 9484, 9505, 9524, 9529, 9533, 9548, 9556, 9589, 9662, 9667, 9676, 9730, 9749, 9786, 9791, 9812, 9813, 9816, 9822, 9861, 9873, 9886, 9888, 9890, 9934, 9941, 9953);
        int[] B = ArrayUtils.asArrays(6, 23, 38, 44, 73, 76, 98, 99, 108, 119, 128, 156, 175, 188, 203, 221, 238, 252, 254, 281, 296, 315, 330, 336, 340, 361, 370, 419, 491, 508, 516, 521, 524, 531, 543, 556, 557, 590, 609, 613, 615, 635, 642, 677, 678, 689, 705, 708, 717, 721, 730, 745, 754, 761, 786, 799, 814, 868, 887, 899, 903, 909, 929, 955, 962, 969, 973, 990, 1027, 1086, 1094, 1114, 1136, 1143, 1148, 1157, 1173, 1174, 1185, 1207, 1210, 1216, 1231, 1237, 1277, 1283, 1290, 1309, 1331, 1340, 1368, 1376, 1376, 1381, 1390, 1414, 1436, 1442, 1477, 1514, 1529, 1589, 1593, 1619, 1643, 1668, 1751, 1755, 1772, 1779, 1780, 1786, 1789, 1801, 1805, 1807, 1814, 1820, 1836, 1856, 1856, 1863, 1903, 1906, 1919, 1930, 1936, 1941, 1999, 2003, 2003, 2015, 2053, 2069, 2075, 2077, 2089, 2092, 2118, 2129, 2132, 2149, 2157, 2199, 2199, 2215, 2216, 2218, 2219, 2244, 2268, 2274, 2281, 2283, 2303, 2330, 2330, 2334, 2355, 2358, 2375, 2375, 2394, 2396, 2433, 2444, 2456, 2458, 2482, 2517, 2539, 2558, 2559, 2598, 2670, 2675, 2675, 2695, 2697, 2727, 2728, 2761, 2772, 2778, 2792, 2810, 2814, 2827, 2831, 2834, 2837, 2883, 2885, 2888, 2901, 2906, 2907, 2909, 2927, 2939, 2948, 2991, 2996, 3012, 3013, 3029, 3039, 3081, 3093, 3097, 3099, 3137, 3158, 3197, 3208, 3214, 3219, 3221, 3221, 3241, 3251, 3264, 3270, 3280, 3286, 3289, 3297, 3304, 3305, 3327, 3330, 3346, 3348, 3383, 3386, 3388, 3405, 3437, 3471, 3472, 3475, 3490, 3542, 3542, 3545, 3550, 3557, 3563, 3584, 3607, 3613, 3624, 3635, 3640, 3647, 3648, 3670, 3719, 3741, 3749, 3762, 3771, 3784, 3787, 3801, 3805, 3809, 3828, 3856, 3875, 3905, 3909, 3982, 4016, 4033, 4053, 4054, 4076, 4078, 4088, 4094, 4150, 4151, 4160, 4182, 4190, 4213, 4219, 4221, 4229, 4248, 4274, 4299, 4318, 4326, 4350, 4351, 4362, 4371, 4373, 4406, 4438, 4441, 4463, 4467, 4471, 4481, 4492, 4508, 4509, 4526, 4544, 4560, 4578, 4637, 4704, 4712, 4716, 4732, 4738, 4763, 4773, 4775, 4788, 4823, 4827, 4836, 4846, 4850, 4881, 4883, 4895, 4913, 4918, 4930, 4936, 4948, 4960, 4965, 4975, 4977, 4978, 4986, 5002, 5014, 5034, 5045, 5047, 5047, 5052, 5055, 5055, 5076, 5079, 5081, 5112, 5141, 5154, 5156, 5178, 5185, 5201, 5256, 5265, 5277, 5288, 5293, 5296, 5332, 5332, 5349, 5353, 5366, 5396, 5396, 5396, 5421, 5453, 5456, 5465, 5484, 5487, 5500, 5536, 5553, 5563, 5565, 5586, 5590, 5590, 5590, 5607, 5609, 5653, 5663, 5684, 5709, 5715, 5719, 5735, 5741, 5746, 5747, 5754, 5783, 5789, 5829, 5835, 5895, 5896, 5903, 5914, 5931, 5933, 5960, 5961, 5963, 5979, 5995, 6009, 6015, 6026, 6030, 6037, 6038, 6045, 6057, 6083, 6109, 6111, 6125, 6134, 6137, 6143, 6159, 6165, 6165, 6169, 6195, 6210, 6240, 6265, 6275, 6285, 6297, 6301, 6312, 6312, 6318, 6359, 6378, 6381, 6384, 6397, 6419, 6426, 6430, 6436, 6441, 6449, 6458, 6534, 6547, 6551, 6554, 6558, 6560, 6569, 6587, 6590, 6602, 6613, 6636, 6637, 6658, 6664, 6680, 6688, 6688, 6704, 6716, 6736, 6747, 6782, 6807, 6854, 6868, 6874, 6895, 6903, 6911, 6925, 6926, 6933, 6933, 6957, 6959, 6981, 6997, 7005, 7059, 7079, 7088, 7089, 7091, 7097, 7098, 7122, 7136, 7142, 7156, 7176, 7178, 7180, 7180, 7217, 7224, 7235, 7264, 7310, 7314, 7314, 7315, 7340, 7347, 7354, 7354, 7362, 7381, 7386, 7412, 7426, 7426, 7447, 7449, 7461, 7474, 7482, 7575, 7604, 7630, 7642, 7655, 7669, 7670, 7686, 7687, 7704, 7715, 7726, 7733, 7787, 7824, 7825, 7833, 7878, 7894, 7903, 7924, 7931, 7931, 7957, 7960, 7984, 7987, 7991, 8018, 8022, 8029, 8039, 8066, 8078, 8105, 8124, 8133, 8137, 8150, 8184, 8185, 8193, 8212, 8213, 8223, 8234, 8241, 8259, 8268, 8300, 8318, 8321, 8330, 8354, 8355, 8425, 8444, 8448, 8453, 8458, 8475, 8497, 8505, 8519, 8524, 8542, 8555, 8580, 8581, 8608, 8611, 8684, 8693, 8704, 8726, 8764, 8776, 8783, 8790, 8810, 8811, 8822, 8864, 8881, 8903, 8912, 8933, 8935, 8955, 8971, 8982, 9021, 9023, 9068, 9069, 9080, 9082, 9135, 9137, 9140, 9154, 9168, 9177, 9187, 9220, 9226, 9232, 9268, 9271, 9276, 9277, 9298, 9332, 9353, 9356, 9381, 9393, 9435, 9438, 9467, 9478, 9504, 9514, 9529, 9612, 9628, 9652, 9668, 9670, 9700, 9724, 9726, 9731, 9735, 9740, 9759, 9770, 9787, 9794, 9803, 9814, 9858, 9870, 9874, 9896, 9904, 9907, 9920, 9920, 9924, 9933, 9971, 9977);
        int[] C = ArrayUtils.asArrays(28, 30, 44, 45, 59, 96, 98, 108, 112, 139, 140, 161, 163, 166, 178, 192, 204, 211, 214, 220, 222, 228, 237, 245, 252, 252, 260, 293, 303, 306, 334, 344, 346, 351, 361, 375, 378, 402, 418, 431, 439, 447, 452, 483, 486, 490, 492, 499, 513, 532, 548, 576, 593, 631, 637, 639, 681, 683, 699, 707, 725, 726, 730, 763, 771, 778, 783, 826, 850, 851, 860, 883, 899, 910, 915, 926, 933, 951, 951, 956, 974, 983, 997, 1023, 1026, 1033, 1040, 1056, 1057, 1099, 1106, 1111, 1114, 1119, 1126, 1139, 1162, 1163, 1164, 1168, 1171, 1172, 1191, 1194, 1222, 1224, 1260, 1268, 1276, 1279, 1280, 1330, 1346, 1350, 1365, 1372, 1383, 1386, 1395, 1438, 1439, 1451, 1457, 1458, 1491, 1501, 1516, 1518, 1526, 1607, 1640, 1646, 1650, 1658, 1669, 1671, 1682, 1683, 1683, 1684, 1686, 1687, 1688, 1695, 1698, 1698, 1700, 1709, 1710, 1712, 1723, 1740, 1760, 1787, 1807, 1810, 1816, 1831, 1859, 1868, 1877, 1892, 1894, 1897, 1905, 1906, 1927, 1928, 1935, 1938, 1965, 1990, 1992, 1994, 1997, 2010, 2011, 2018, 2033, 2034, 2041, 2048, 2053, 2067, 2077, 2100, 2102, 2111, 2113, 2117, 2118, 2134, 2149, 2155, 2191, 2195, 2202, 2223, 2233, 2253, 2253, 2269, 2298, 2310, 2325, 2335, 2375, 2383, 2425, 2431, 2439, 2497, 2499, 2506, 2510, 2512, 2532, 2534, 2537, 2538, 2540, 2571, 2581, 2584, 2585, 2593, 2603, 2615, 2618, 2625, 2626, 2636, 2651, 2653, 2661, 2679, 2699, 2722, 2726, 2742, 2761, 2766, 2772, 2773, 2774, 2782, 2785, 2792, 2793, 2827, 2836, 2866, 2868, 2868, 2872, 2888, 2905, 2906, 2933, 2942, 2964, 2973, 2986, 3027, 3036, 3056, 3105, 3106, 3129, 3143, 3155, 3160, 3167, 3176, 3180, 3201, 3214, 3222, 3225, 3247, 3250, 3271, 3290, 3298, 3303, 3305, 3313, 3329, 3329, 3346, 3357, 3363, 3367, 3371, 3415, 3426, 3443, 3447, 3457, 3482, 3488, 3489, 3489, 3491, 3518, 3520, 3544, 3564, 3568, 3570, 3602, 3606, 3633, 3646, 3648, 3667, 3678, 3702, 3726, 3731, 3744, 3755, 3782, 3783, 3790, 3792, 3793, 3802, 3802, 3816, 3822, 3823, 3824, 3825, 3828, 3842, 3865, 3878, 3881, 3889, 3907, 3930, 3938, 3938, 3956, 3961, 3966, 4002, 4002, 4003, 4007, 4033, 4033, 4039, 4040, 4058, 4068, 4074, 4082, 4094, 4109, 4132, 4140, 4152, 4171, 4191, 4197, 4224, 4227, 4230, 4235, 4239, 4242, 4243, 4249, 4249, 4268, 4287, 4295, 4309, 4311, 4328, 4331, 4353, 4360, 4363, 4366, 4385, 4387, 4400, 4412, 4471, 4483, 4486, 4488, 4489, 4504, 4508, 4518, 4521, 4530, 4534, 4561, 4594, 4612, 4631, 4634, 4661, 4695, 4701, 4709, 4713, 4713, 4728, 4733, 4745, 4767, 4772, 4773, 4800, 4805, 4806, 4841, 4845, 4846, 4858, 4901, 4909, 4966, 4970, 4982, 5061, 5064, 5066, 5071, 5090, 5093, 5095, 5117, 5123, 5154, 5156, 5162, 5175, 5179, 5184, 5200, 5219, 5225, 5253, 5280, 5293, 5295, 5323, 5324, 5351, 5352, 5372, 5391, 5395, 5399, 5399, 5404, 5422, 5427, 5435, 5462, 5465, 5469, 5478, 5507, 5507, 5517, 5532, 5562, 5563, 5571, 5576, 5590, 5592, 5596, 5606, 5620, 5624, 5630, 5635, 5652, 5659, 5675, 5675, 5685, 5706, 5747, 5750, 5763, 5770, 5809, 5813, 5815, 5832, 5836, 5837, 5860, 5870, 5874, 5888, 5889, 5894, 5897, 5904, 5909, 5910, 5931, 5939, 5942, 5942, 5961, 5967, 5970, 5981, 6020, 6038, 6038, 6039, 6048, 6051, 6057, 6067, 6070, 6104, 6111, 6111, 6115, 6129, 6130, 6133, 6137, 6141, 6149, 6150, 6154, 6178, 6192, 6207, 6220, 6222, 6238, 6248, 6273, 6278, 6283, 6283, 6284, 6293, 6296, 6297, 6298, 6298, 6319, 6353, 6377, 6378, 6401, 6424, 6430, 6433, 6442, 6443, 6451, 6495, 6495, 6498, 6498, 6498, 6513, 6519, 6528, 6534, 6542, 6546, 6561, 6568, 6592, 6627, 6631, 6647, 6649, 6656, 6657, 6673, 6673, 6682, 6684, 6692, 6698, 6708, 6709, 6714, 6750, 6777, 6797, 6800, 6805, 6810, 6811, 6825, 6845, 6851, 6870, 6893, 6898, 6898, 6902, 6904, 6920, 6934, 6950, 6965, 6977, 6982, 7009, 7017, 7024, 7027, 7041, 7088, 7125, 7127, 7129, 7130, 7130, 7153, 7183, 7188, 7199, 7200, 7201, 7204, 7213, 7232, 7235, 7248, 7275, 7309, 7310, 7312, 7316, 7327, 7343, 7351, 7358, 7370, 7387, 7409, 7409, 7414, 7427, 7433, 7440, 7448, 7449, 7452, 7457, 7458, 7459, 7472, 7476, 7483, 7492, 7524, 7548, 7554, 7558, 7559, 7561, 7571, 7573, 7587, 7604, 7617, 7650, 7654, 7667, 7668, 7677, 7681, 7694, 7707, 7724, 7728, 7757, 7761, 7762, 7786, 7790, 7799, 7799, 7799, 7810, 7810, 7821, 7827, 7832, 7852, 7855, 7858, 7863, 7875, 7882, 7885, 7899, 7899, 7954, 7963, 7967, 7968, 7981, 7983, 7991, 8045, 8051, 8055, 8071, 8080, 8091, 8096, 8105, 8113, 8116, 8124, 8128, 8149, 8161, 8191, 8191, 8201, 8202, 8212, 8216, 8224, 8245, 8250, 8264, 8268, 8282, 8298, 8315, 8319, 8325, 8363, 8369, 8380, 8407, 8417, 8454, 8481, 8487, 8501, 8538, 8538, 8541, 8561, 8569, 8584, 8587, 8596, 8599, 8602, 8618, 8627, 8628, 8647, 8668, 8673, 8684, 8691, 8704, 8713, 8726, 8728, 8734, 8738, 8754, 8759, 8767, 8792, 8792, 8800, 8804, 8806, 8821, 8826, 8833, 8839, 8843, 8845, 8848, 8861, 8894, 8902, 8906, 8907, 8908, 8911, 8913, 8917, 8936, 8943, 8946, 8967, 9012, 9035, 9036, 9043, 9048, 9056, 9058, 9068, 9082, 9089, 9096, 9116, 9144, 9151, 9160, 9163, 9165, 9171, 9203, 9210, 9218, 9224, 9230, 9237, 9245, 9256, 9261, 9269, 9309, 9323, 9348, 9359, 9362, 9368, 9371, 9372, 9377, 9427, 9429, 9438, 9451, 9515, 9516, 9528, 9528, 9545, 9566, 9568, 9593, 9607, 9614, 9632, 9638, 9642, 9655, 9672, 9672, 9675, 9689, 9700, 9708, 9721, 9737, 9738, 9746, 9754, 9757, 9764, 9776, 9786, 9791, 9801, 9803, 9820, 9825, 9831, 9836, 9836, 9868, 9877, 9884, 9889, 9946, 9956, 9996);

        Array3Pointers obj = new Array3Pointers();
        int minimize = obj.minimize(A, B, C);
        System.out.println(minimize);
    }


    public int minimize(final int[] A, final int[] B, final int[] C) {

        int i = 0;
        int j = 0;
        int k = 0;
        int p = A.length;
        int q = B.length;
        int r = C.length;
        int min = Integer.MAX_VALUE;
        while (i < p && j < q && k < r) {

            int ij = Math.abs(A[i] - B[j]);
            int jk = Math.abs(B[j] - C[k]);
            int ki = Math.abs(C[k] - A[i]);

            int sum = Math.max(ij, Math.max(jk, ki));
            min = Math.min(min, sum);

            if (ij >= jk && ij >= ki) {
                if (A[i] < B[j]) {
                    i++;
                } else {
                    j++;
                }
            } else if (jk >= ij && jk >= ki) {
                if (B[j] < C[k]) {
                    j++;
                } else {
                    k++;
                }
            } else {
                if (C[k] < A[i]) {
                    k++;
                } else {
                    i++;
                }
            }
        }

        return min;
    }

    void findClosest(int A[], int B[], int C[]) {
        int diff = Integer.MAX_VALUE; // Initialize min diff
        int p = A.length;
        int q = B.length;
        int r = C.length;

        int res_i = 0, res_j = 0, res_k = 0;


        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r) {

            int minimum = Math.min(A[i],
                    Math.min(B[j], C[k]));
            int maximum = Math.max(A[i],
                    Math.max(B[j], C[k]));


            if (maximum - minimum < diff) {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = maximum - minimum;
            }


            if (diff == 0) break;

            if (A[i] == minimum) i++;
            else if (B[j] == minimum) j++;
            else k++;
        }

        System.out.println(A[res_i] + " " +
                B[res_j] + " " + C[res_k]);
    }
}

/*
    Look for copy for reference.

    The Second technique look amazing to me.
    See the Max(abs(),abs(),abs()) will actually
    one value out of the three absolute and
    since we are taking all the combination of the three number.
    Max(a,b,c) - Min(a,b,c) will work.
    And now we just have to minimize this.
    We can start from i j k as 0 and increase the number which is minimum everytime
    and it would work.

    So,
    You can find that out look at the code you will understand.

 */